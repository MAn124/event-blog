import { Component, OnInit } from '@angular/core';
import { Role } from '../../../core/interface/role';
import { User } from '../../../core/interface/user';
import { RoleService } from '../../../core/service/role.service';
import { UserService } from '../../../core/service/user.service';
import { MessageService } from 'primeng/api';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrl: './user-management.component.css',
  providers: [MessageService],
})
export class UserManagementComponent {
  roles!: Role[];
  users!: User[];
  user!: User;
  formGroup!: FormGroup
  isVisible: boolean = false;
  isEditable: boolean = false;
  isSearched: boolean = false;
  constructor(
    private roleService: RoleService,
    private userService: UserService,
    private messageService: MessageService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
  
     this.getUsers();
   
   this.getRoles();
  }

  getRoles() {
    this.roleService.getAllRoles().subscribe({
      next: (roles) => {
        this.roles = roles;
        console.log('Roles :', this.roles);
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
  getRole(id: number){
    return this.roles.find(role => role.id === id)?.name;
  }
  getUsers() {
    this.userService.getAllUsers().subscribe({
      next: (users) => {
        this.users = users;
        console.log('User :', this.users);
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
 
  openDialogEdit(user: any) {
    this.isEditable = true;
    this.isVisible = true;
    this.user = { ...user };
  }
  openDialogNew() {
    this.isEditable = false;
    this.isVisible = true;
    this.user = {
      active: true,
      role: 2,
    };
  }
  save() {
    if (this.user.id) {
      this.userService.update(this.user.id, this.user).subscribe({
        next: (id) => {
          this.isVisible = false;
          const index = this.users.findIndex(
            (user) => user.id === this.user.id
          );
          if (index != -1) {
            this.users[index] = this.user;
          }
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: 'Message Content',
          });
        },
        error: (error) => {
          console.log(error);
        },
      });
    } else {
      this.userService.create(this.user).subscribe({
        next: (id) => {
          this.user.id = id;
          console.log(id);
          this.isVisible = false;
          this.users.unshift({
            ...this.user,
            id: id,
            
          });
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: 'Message Content',
          });
        },
        error: (error) => {
          console.log(error);
        },
      });
    }
  }
  doSearch(value: string){
    this.userService.searchUser(value).subscribe({
      next: (users) => {
        this.users = users;
        console.log(users);
      },
      error: (error) => {
        console.log(error);
      },
    })
  }
}
