#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib> 
using namespace std;
// random generator function:
int myrandom (int i) { return std::rand()%i;}
int main(int args, char* argv[]) {
    std::vector<std::string> odds; // on stack
	std::vector<std::string>* even = new std::vector<std::string>;
	for( int i = 0 ; i < args ; ++i ) {
		char* ptr1 = argv[i];
       int count = 0;
       while ( *ptr1 != '\0' )
      {
     ++count;
     ++ptr1;
     }
	// std::string str = std::to_string(argv[i]);
	 if (count % 2 == 0)
    {	
    even->push_back(argv[i]); 
	} else {
		odds.push_back(argv[i]);
	}
	}
	std::sort (odds.begin(), odds.end()); 
    random_shuffle(even->begin(), even->end(), myrandom);	
	std::cout << "Odd lengths:\n";
    for(auto j : odds) std::cout << j << std::endl;
	
	std::cout << "Even lengths:\n";
	for(auto k : *even) std::cout << k << std::endl;
}