#include "university.h"
#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <iomanip>
using namespace std;
typedef std::vector<std::string> Universities;
typedef std::string State;

int main (int argc, char const* argv[]) {
	
     if(argc != 2) {
        std::cerr << "Exactly 2 arguments needed" << std::endl;
        return -1;
    }
	std::ifstream ifs{std::string{argv[1]}};
		if (!ifs) throw std::runtime_error{"can’t open input file"};
    std::string infile  = (argc>1) ? std::string{argv[1]} : "";
	
	State State;
	std::string univ_name;	
	std::string name;
	std::string enroll;
	std::string line;
    std::string state_name;
	std::string state_abbrev;	
	std::multimap<std::string, University> college_map;	
    std::string abrevfile = "state_abbrev.txt";
	std::ifstream ifs1{std::string {abrevfile}};
	std::map<std::string, std::string> state_map;
	 while (!ifs1.eof())
    {
        std::getline(ifs1, state_name);	   
		std::getline(ifs1, state_abbrev);
		state_map.insert({ state_abbrev, state_name}); 
	}	
	for (const auto& [key, value] : state_map)
   {
    std::cout << key << " " << value << std::setw(6);
   }	
    while (!ifs.eof())
    {
        std::getline(ifs, State);	   
		std::getline(ifs, univ_name);
		std::getline(ifs, enroll);
        int reg_num = stoi(enroll); 		
		std::string info;
		University univ (univ_name,reg_num);		
		college_map.insert(std::make_pair(State, univ));		
	}
     	std::string in;			
		while(std::cin) {
        std::cout << "Which State (2-character abreviation): ";
        if(std::cin >> in) {		
	   multimap<std::string, University>::iterator itr1;
       itr1 = college_map.find(in); 
		if(itr1 == college_map.end()){
		cout <<  "No universities found in the map" << endl; 
		continue;
		}		
		for (itr1 = college_map.begin(); itr1 != college_map.end(); ++itr1) {
        if(itr1->first == in){
		cout << '\t' << itr1->first << '\t' << itr1->second
             << '\n';
		}
    }   
    }	
	}			
	}
	

