import {Injectable} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private PATH = "/graphql";
  private HOST = "http://localhost:8080";
  private fullUrl = this.HOST + this.PATH;

  constructor(private apollo: Apollo) {
  }

  getUsers(): Observable<any> {
    return this.apollo
      .watchQuery({
        notifyOnNetworkStatusChange: true,
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
      .valueChanges.pipe(map((result: any) => {
        console.error(JSON.stringify(result));
        return result.data?.users || []
      }));
  }
}
