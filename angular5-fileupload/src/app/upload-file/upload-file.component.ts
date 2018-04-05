import { Component, OnInit } from '@angular/core';
import { UploadFileService } from '../upload-file.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent implements OnInit {

  title="File Upload with Angular5"

  selectedFiles: FileList;
  currentFileUpload: File;

  constructor(private uploadFile: UploadFileService) { }

  selectFile(event) {
    this.selectedFiles = event.target.files;
    console.log(this.selectedFiles.length);
  }

  ngOnInit() {
  }

  upload(){

    for(var i=0;i<=this.selectedFiles.length;i++){
    this.currentFileUpload = this.selectedFiles.item(i);
    this.uploadFile.storeFile(this.currentFileUpload).subscribe(event => {

      if(event instanceof HttpResponse){
        console.log('file is uploaded');
      }
    });
    
 }
  this.selectedFiles=undefined;
  }

}
