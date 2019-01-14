import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError} from 'rxjs';
import {Book} from './book';
import { map, catchError } from 'rxjs/operators';

@Injectable()
export class BookService {

    constructor(private _httpService: HttpClient){}

    getAllBooks(): Observable<any> {
        return this._httpService.get("http://localhost:8080/api/book")
            .pipe(
                catchError((e:Response)=> this.handleError(e))
            );
    }

    private handleError(error: Response) {
        return throwError(error);
    }

    addBook(book: Book) {
        let body = JSON.stringify(book);
        let headers = new HttpHeaders({'Content-Type': 'application/json'});
        return this._httpService.post("http://localhost:8080/api/book", body, {
            headers: headers
        });;
    }
}