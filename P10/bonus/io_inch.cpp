#include "inch.h"
#include <iostream>
#include <sstream>
#include <fstream> 

int main (int argc, char const* argv[]) {
    int vector = 1;
    int result = 0;
    std::ostringstream oss;
    std::string actual;
    std::string expected;
	std::ifstream ifs ("test.txt", std::ifstream::in);
   std::ofstream ofs ("test1.txt", std::ofstream::out);
  char c = ifs.get();

  while (ifs.good()) {
    std::cout << c;
	ofs << c;
    c = ifs.get(); 
  }

  ifs.close();   
  ofs.close();  
    return 0;
}