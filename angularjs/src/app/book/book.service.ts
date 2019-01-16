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
        console.log(body);
        let headers = new HttpHeaders({'Content-Type': 'application/json'});
        if (book.id) {
            return this._httpService.put("http://localhost:8080/api/book/"+book.id, body, {
                headers: headers
            });
        }
        return this._httpService.post("http://localhost:8080/api/book", body, {
            headers: headers
        });;
    }

    deleteBook(bookId: string) {
        return this._httpService.delete("http://localhost:8080/api/book/"+bookId);
    }

    getBookById(bookId: string): Observable<any>{
        return this._httpService.get("http://localhost:8080/api/book/"+bookId)
            .pipe(
                catchError((e: Response) => this.handleError(e))
            )
    }
}