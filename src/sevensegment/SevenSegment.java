package sevensegment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Convert 7-segment representation of digits to character digits * 
 * @author Aakash
 */
public class SevenSegment {    
    
    /**
    * Converts the input 7-segment numbers into String.     *
    * @param  filename  location of file with 7-segment input
    * @return      the converted String
    */
    public String[] convert(String filename)
    {
        String[] result = new String[3];
        
        char[][] digit = new char[3][3];
        int x,y=0;
        boolean flag=true;
        try
        {
            File file = new File(filename); 
            BufferedReader br = new BufferedReader(new FileReader(file));   

            while(flag)
            {
               String[] temp = new String[3];
               for(x=0;x<3;x++) //read 3 lines
               {
                  if((temp[x] = br.readLine())==null)
                  {
                      flag=false;
                      break;
                  }
               } 
               if(!flag)
                   break; //no more lines to process
               
               if(x==3)
               {
                  for(int i=0;i<temp[0].length();i++)
                  {
                      for(int j=0;j<3;j++)
                      {
                          digit[0][j]=temp[0].charAt(i);
                          digit[1][j]=temp[1].charAt(i);
                          digit[2][j]=temp[2].charAt(i);
                          i++;    
                      }
                      if(result[y]==null)
                        result[y]=""+getDigit(digit);
                      else
                          result[y]+=getDigit(digit);   
                  }
               }
               y++;
               br.readLine(); // skip space line
            }            
        }
        
        catch(IOException e)
        {
            e.printStackTrace(); 
        }
        return result;
    }
    
    /**
    * Converts the given 7-segment number into character.     *
    * @param  digit  7-segment representation of a single digit
    * @return      the converted character
    */
    public char getDigit(char[][] digit)
    {
        char[][] zero ={{' ','_',' '},{'|',' ','|'},{'|','_','|'}};
        char[][] one  ={{' ',' ',' '},{'|',' ',' '},{'|',' ',' '}};
        char[][] two  ={{' ','_',' '},{' ','_','|'},{'|','_',' '}};
        char[][] three={{' ','_',' '},{' ','_','|'},{' ','_','|'}};
        char[][] four ={{' ',' ',' '},{'|','_','|'},{' ','|',' '}};
        char[][] five ={{' ','_',' '},{'|','_',' '},{' ','_','|'}};
        char[][] six  ={{' ','_',' '},{'|','_',' '},{'|','_','|'}};
        char[][] seven={{' ','_',' '},{' ',' ','|'},{' ',' ','|'}};
        char[][] eight={{' ','_',' '},{'|','_','|'},{'|','_','|'}};
        char[][] nine ={{' ','_',' '},{'|','_','|'},{' ','_','|'}};      
                        
        if(digit[0][1]==' ')
        {
            if(match(digit,one))
                return '1';
            else if(match(digit,four))
                return '4';
            else 
                return '*';
        }
        else if(digit[1][1]==' ')
        {
            if(match(digit,zero))
                return '0';
            else if(match(digit,seven))
                return '7';
            else
                return '*';
        }
        else if(digit[2][0]=='|')
        {
            if(match(digit,two))
                return '2';
            else if(match(digit,six))
                return '6';
            else if(match(digit,eight))
                return '8';
            else
                return '*';
        }
        else
        {
            if(match(digit,three))
                return '3';
            else if(match(digit,five))
                return '5';
            else if(match(digit,nine))
                return '9';
            else
                return '*';
        }
    }
    
    /**
     * Compares the 2 character arrays and returns True if they match.
     *
     *
     * @param a 7-segment representation of the first digit
     * @param b 7-segment representation of the second digit
     * @return True if the digits are equal, else False
     */
    public boolean match(char[][] a,char[][] b)
    {
        for(int i=0;i<3;i++)
        {                 
            for(int j=0;j<3;j++)
            {
                if(a[i][j]!=b[i][j])
                    return false;
            }                
        }   
        return true;
    }
}
