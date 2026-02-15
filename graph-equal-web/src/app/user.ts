import { Injectable } from '@angular/core';
import { Apollo, gql } from 'apollo-angular';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class User {
  private PATH = "/graphql";
  private HOST = "http://localhost:4000";
  private fullUrl = this.HOST + this.PATH;

  constructor(private apollo: Apollo) { }

  getUsers(): Observable<any> {
    return this.apollo
      .watchQuery({
        query: gql`
          query {
            users {
              id
              firstName
              lastName
              email
              orders {
                id
                userId
                product
                __typename
              }
              __typename
            }
          }
        `,
        context: {
          uri: this.fullUrl,
        },
      })
      .valueChanges.pipe(map((result: any) => result.data.users));
  }
}
