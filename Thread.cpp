#pragma warning(disable:4996)
#include"HeadFile.h"

#include<process.h>

#include<iostream>
#include<vector>
#include<stdio.h>
#include<stdlib.h>
#include <Windows.h>

using namespace std;
int time_manager(char comm[]);

int hour,minn,sec;

DWORD WINAPI output(LPVOID pm){//新建线程函数
        while (1)
        {
          hour=time_manager("hour");
          minn=time_manager("minute");
          sec=time_manager("second");
          /* code */
          if(time_manager("hour")>=21&&time_manager("minute")>=00)cout<<"ok\n";
          cout<<hour<<":"<<minn<<":"<<sec<<endl;
          Sleep(1*1000);
        }
        
        return 0;
}
int start_thread(){//开启线程
  HANDLE handle=CreateThread(NULL,0,output,NULL,0,NULL);
  WaitForSingleObject(handle,INFINITE);
return 0;
}
