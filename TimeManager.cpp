#pragma warning(disable:4996)
#include "HeadFile.h"
#include<stdio.h>
#include<string.h>
#include<time.h>

using namespace std;

 
 int  time_manager(char time_comm[]){//获取时间
   struct tm  *t;//结构体
   time_t time_request;//声明time_t类型变量
    time_request=time(&time_request);//获取系统日期和时间
  t=localtime(&time_request);//获取本地时间

if (strcmp(time_comm,"hour")==0){
  return t->tm_hour;
}else if(strcmp(time_comm,"minute")==0){
    return t->tm_min;
    }else if(strcmp(time_comm,"second")==0){
      return t->tm_sec;
    }else {  
      printf("dfsdfsd\n");return 0;
      }
}