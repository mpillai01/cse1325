// NOTE: This regression test is provided AS IS, with no warranty 
// of merchantability or warranty of fitness for a particular purpose.

// Passing this regression test does not guarantee that your code is correct.
// Failing this regression test does not guarantee that your code is incorrect.
// But it may give you a hint...

#include "inch.h"

#include <iostream>
#include <sstream>

int main (int argc, char const* argv[]) {
    int vector = 1;
    int result = 0;
    std::ostringstream oss;
    std::string actual;
    std::string expected;
    
    std::cout<<"Enter one or more measurements(in inches): "<<std::endl;
	
                Inch inch1;
                std::cin>>inch1;
				
			//	Inch inn3; inch1 >> inn3;
				std::cout<< "You entered " <<inch1;
    
     std::cout<<"Enter one or more measurements(in inches): "<<std::endl;
	
                Inch inch2;
                std::cin>>inch2;
				
			//	Inch inn3; inch1 >> inn3;
				std::cout<< "You entered " <<inch2 <<"\n";
				if(inch1 != inch2) {
            std::cerr << "inches reported as not equal\n";
				}
            if(!(inch1 <= inch2))  {
			std::cerr << "inch1 is not <= inch2 \n";	
        }
		if((inch1 >= inch2))  {
			std::cerr << "inch1 is >= inch2 \n";	
        }
		Inch sum = inch1 + inch2;
		std::cout<< "Sum of two inches " <<sum <<"\n";
		
    return 0;
}