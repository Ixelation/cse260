public class Testing{
    public static void main(String args[]){
        int a=0, b=0, c=0, d=0, nonc=0, octc=0, numc=0, temp=0;
        for (int i=0; i<=9999; i++){
            a=i/1000;
            temp=i%1000;
            b=temp/100;
            temp=temp%100;
            c=temp/10;
            temp=temp%10;
            if (a==8){octc++;}
            if (b==8){octc++;}
            if (c==8){octc++;}
            if (d==8){octc++;}
            if (a==9){nonc++;}
            if (b==9){nonc++;}
            if (c==9){nonc++;}
            if (d==9){nonc++;}
            if(octc==1&&nonc==1) {numc++;}
            nonc=0; octc=0;
        }
        System.out.println(numc);
    }
}