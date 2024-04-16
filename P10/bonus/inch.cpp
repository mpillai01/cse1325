#include "inch.h"
#include <numeric> 
#include <stdexcept>
#include <algorithm>
#include <exception>

Inch::Inch(int whole,int numerator,int denominator) : _whole{whole}, _numerator{numerator}, _denominator{denominator} {   
validate();
}
Inch::Inch(): Inch{0,0,2}{
}
std::ostream& operator<<(std::ostream& os, const Inch& inch) { 
	os << inch._whole << " " << inch._numerator << "/" << inch._denominator;  
	return os;
}

std::istream& operator>>(std::istream& is, Inch& inch) {
	//std::cout << inch._whole;
	//std::cout << inch._numerator;
	//std::cout << inch._denominator;
	
    is >> inch._whole;
    is >> inch._numerator;
    is >> inch._denominator; 
    return is;
}

int Inch::compare(const Inch& rhs) {
	if(_whole <rhs._whole ) return -1;
    if(_whole >rhs._whole ) return  1;
    if(_numerator<rhs._numerator) return -1;
    if(_numerator>rhs._numerator) return  1;
    if(_denominator  <rhs._denominator  ) return -1;
    if(_denominator  >rhs._denominator  ) return  1;
    return 0; 
}

void Inch::validate(){
	//std::cout << _denominator;
	
	if(_denominator!=2 && _denominator!=4 && _denominator!=8 && _denominator!=16 && _denominator!=32 && _denominator!=64)
	{
		
		throw std::invalid_argument{"Denominator must be 2, 4, 8, 16, 32, or 64"}; 
	}
	
	while(_denominator <= _numerator)
	{
		_numerator = _numerator - _denominator;
		_whole++;
	}
	
	const int gcd{ std::gcd(_numerator,_denominator) };
		_numerator /= gcd;
		_denominator /= gcd;
		
}


