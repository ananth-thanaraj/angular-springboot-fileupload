import { Injectable } from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UploadFileService {

  constructor(private http: HttpClient) { }

  storeFile(file: File): Observable<HttpEvent<{}>>{
    const formData: FormData = new FormData();
    formData.append('file', file);

    const req = new HttpRequest('POST', 'http://localhost:8080/file/upload/picture', formData, {
      reportProgress: true,
      responseType: 'text'
    }
    );

    return this.http.request(req);
  }

}
