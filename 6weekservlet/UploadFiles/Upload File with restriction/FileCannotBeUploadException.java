package com.servlet.upload;

public class FileCannotBeUploadException extends Exception
{
 private String message=null;
 public FileCannotBeUploadException()
 {
  super(); 
 }
 public FileCannotBeUploadException(String message)
 {
  super(); 
  message=message;  
 }
 public FileCannotBeUploadException(Throwable cause)
 {
  super(cause); 
 }
 
 @Override
 public String toString()
 {
  return message; 
 }
 
 @Override
 public String getMessage()
 {
  return message; 
 }
}