import { Component, OnInit } from '@angular/core';
import { Role } from '../../../core/interface/role';
import { User } from '../../../core/interface/user';
import { RoleService } from '../../../core/service/role.service';
import { UserService } from '../../../core/service/user.service';
import { MessageService } from 'primeng/api';

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
  isVisible: boolean = false;
  isEditable: boolean = false;

  constructor(
    private roleService: RoleService,
    private userService: UserService,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.getRoles();
    this.getUsers();
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
      role: 1,
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
          this.users.push({
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
}
