#pragma warning(disable:4996)
#include<stdio.h>
#include"HeadFile.h"
#include<Windows.h>
#include<string.h>
#include<time.h>

//-----------------------其他文件的函数声明
int start_thread();
int time_manager(char comm[]);
//--------------------

int main(void){//主方法
for(int i=0;i<4;i++){
    if(time_manager((char*)"hour")>=00){
        printf("%d:%d\n",time_manager((char*)"hour"),time_manager((char*)"minute"));
    }
}
start_thread();
    /* code */

return 0;
}