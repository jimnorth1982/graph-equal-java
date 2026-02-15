import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from './user-service';
import {AsyncPipe} from '@angular/common';

@Component({
  selector: 'app-user',
  imports: [
    AsyncPipe
  ],
  templateUrl: './user-component.html',
  styleUrl: './user-component.css'
})
export class UserComponent implements OnInit {
  users$!: Observable<any[]>;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.users$ = this.userService.getUsers();
  }

  protected readonly JSON = JSON;
}
