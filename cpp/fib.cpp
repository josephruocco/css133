#include <iostream>
using namespace std;

int main()
{
    int number, first = 0, second = 1, nextTerm = 0;

    cout << "Enter the number of terms: ";
    cin >> number;

    for (int j = 1; j <= number; ++j)
    {
         if ( j <= 1 )
            nextTerm = j;
        else
      {
           nextTerm = first + second;
            first = second;
            second = nextTerm;
      }
      
      cout << nextTerm << ""; 
    }
    
    return 0;
}
