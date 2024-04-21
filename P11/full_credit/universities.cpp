#include "university.h"
#include <iostream>
#include <fstream>
#include <vector>
#include <map>
using namespace std;
typedef std::vector<std::string> Universities;
typedef std::string State;
typedef std::map<std::string, std::vector<std::string>> University_map;


int main (int argc, char const* argv[]) {
     if(argc != 2) {
        std::cerr << "Exactly 2 arguments needed" << std::endl;
        return -1;
    }
	std::ifstream ifs{std::string{argv[1]}};
		if (!ifs) throw std::runtime_error{"can’t open input file"};
    std::string infile  = (argc>1) ? std::string{argv[1]} : "";
	State State;
	std::string University;	
	std::string name;
	std::string enroll;
	std::string line;	
	University_map college_map;
	std::map<std::string, std::vector<std::string>>::const_iterator it;  

    while (!ifs.eof())
    {
        std::getline(ifs, State);	   
		std::getline(ifs, University);
		std::getline(ifs, enroll);
		
		std::string info;
			info = ""+University+" has an enrollment of "+enroll+"";
		auto value = college_map.find(State);
	if(value != college_map.end()){		
	 vector <string> inVect = (*value).second;	 
	 inVect.push_back(info);
	 (*value).second = inVect;
	
	} else {		
			Universities colleges;
            colleges.push_back(info);
			college_map.insert({ State, colleges}); 
		}
	}
     	std::string in;
			
		while(std::cin) {
        std::cout << "Which State (2-character abreviation): ";
        if(std::cin >> in) {
		auto it = college_map.find(in); 
		if(it == college_map.end()){
		cout <<  "No universities found in the map" << endl; 
		continue;
		}
		cout <<  it->first <<   
       endl; 
	   vector <string> inVect1 = (*it).second;
	
       for (unsigned j=0; j<inVect1.size(); j++){
           cout << inVect1[j] << std::endl;
       }
	}
	}
			
			
	}
	

