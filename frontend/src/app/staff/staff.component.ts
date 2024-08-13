import { Component } from '@angular/core';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrl: './staff.component.css'
})
export class StaffComponent {
  menus = [
    {
      name: 'Posts',
      link: ''
    },
    {
      name:'User management',
      link: 'user-management'
    }
  ]
}
