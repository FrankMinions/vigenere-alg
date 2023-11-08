import java.util.Scanner;
public class Vigenre
{
    public static void main(String[] args)
    {
        int temp,i,j,c,ch=0,column=0,row=0,m=0,t=0;
        char[] v = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[][] v1 = new char[26][26];
        char[] vTemp=new char[26];
        for (i = 0; i < 26; i++)
        {
            temp=i;
            for (j = 0; j < 26-i; j++)
            {
                if(temp!=0)
                {
                    for(c=0;c<temp;c++)
                    {
                        vTemp[c] = v[c];
                    }
                }
                v1[i][j] = v[temp++];
            }
            c=0;
            while(j<26)
            {
                v1[i][j]=vTemp[c++];
                j++;
            }
        }
        Scanner in=new Scanner(System.in);
        System.out.println("Please enter clear text：");
        String name=in.nextLine();
        System.out.println("The input of clear text is："+name);
        Scanner in1=new Scanner(System.in);
        System.out.println("Please enter secret key：");
        String key=in.nextLine();
        System.out.println("Tne input of secret key is："+key);
        char[] stringM=name.toCharArray();
        char[] stringKey=key.toCharArray();
        int k=0,d,temp1=0;
        for(i=0;i<name.length();i++)
        	if(stringM[i]==' ')
        		temp1++;
        	else
        		ch++;
        char[] secret=new char[stringM.length-temp1+1];
        char[] decode=new char[ch];
        for(i=0,d=0;i<name.length();i++,d++)
        {
        	if(stringM[i]==' ')
        		i++;
        	for(j=0;j<26;j++)
        	{
        		
        		if(stringM[i]==v[j])
        		{
        			column=j;
        			break;
        		}
        	}
        	if(stringKey[d]==' ')
        		d++;
        	for(j=0;j<26;j++)
        	{
        		if(stringKey[d]==v[j])
        		{
        			row=j;
        			break;
        		}
        	}
        	secret[k++]=v1[row][column];
        }
        System.out.println("The result of encryption：");
        for(i=0;i<secret.length-1;i++)
        	System.out.print(secret[i]);
        System.out.println("\nThe result of decoding：");
        for(i=0,k=0;i<stringKey.length;i++)
        {
        	if(stringKey[i]!=' ')
        	{
        		for(j=0;j<26;j++)
        		{
        			if(stringKey[i]==v[j])
        			{
        				m=j;
        				break;
        			}
        		}
        		for(int n=0;n<26;n++)
        		{
        			if(secret[k]==v1[m][n])
        			{
        				decode[t++]=v[n];
        				k++;
        				break;
        			}
        		}
        	}
        }
        for(i=0;i<decode.length;i++)
        	System.out.print(decode[i]);  
     }
}
