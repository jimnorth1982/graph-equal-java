import {Component, signal} from '@angular/core';
import {RouterModule} from '@angular/router';
import {UserComponent} from './user/user.component';

@Component({
  selector: 'app-root',
  imports: [UserComponent, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  protected readonly title = signal('graph-equal-web');
}
