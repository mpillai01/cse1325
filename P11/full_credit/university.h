#ifndef __UNIVERSITY_H
#define __UNIVERSITY_H


#include <iostream>

class University{
  public:
	University(std::string _name, int _enrollment);
	std::string name() const;
	int enrollment() const;
	friend std::ostream& operator<<(std::ostream& ost, const University& reading);
	friend std::istream& operator>>(std::istream& ist, University& reading);
    
  private:
    void validate();
    int _enrollment;
    std::string _name;
};

#endif