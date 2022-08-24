#include<stdio.h>
char a(){

return 'a';
}
int main(){
printf("%p   %p\n",a,a());//a是指向栈的入口地址吗
return 0;
}