#ifndef __INCH_H
#define __INCH_H
#include <iostream>
#include <ostream>
#include <algorithm>
class Inch {
public:
	Inch();
	Inch(int whole,int numerator,int denominator);
	//void add_product(Product product);
    inline Inch operator+(const Inch& rhs) {
		/*
		std::cout << _whole;
		std::cout << rhs._whole;
		std::cout << _numerator;
		std::cout << rhs._numerator;
		std::cout << _denominator;
		std::cout << rhs._denominator;
		*/
		
		
		Inch* inch1 = new Inch(_whole,_numerator,_denominator);
		Inch* inch2 = new Inch(rhs._whole,rhs._numerator,rhs._denominator);		
		
		int whole = inch1->_whole+inch2->_whole;
		int numerator= inch1->_numerator+inch2->_numerator;
		int denominator= inch1->_denominator;
		return Inch(whole,numerator,denominator);
		}

	inline bool operator==(const Inch& rhs) {return (compare(rhs) == 0);}
    inline bool operator!=(const Inch& rhs) {return (compare(rhs) != 0);}
    inline bool operator< (const Inch& rhs) {return (compare(rhs) <  0);}
    inline bool operator<=(const Inch& rhs) {return (compare(rhs) <= 0);}
    inline bool operator> (const Inch& rhs) {return (compare(rhs) >  0);}
    inline bool operator>=(const Inch& rhs) {return (compare(rhs) >= 0);}
	friend std::ostream& operator<<(std::ostream& os, const Inch& inch);
    friend std::istream& operator>>(std::istream& is, Inch& inch);
protected:
	int _whole;
	int _numerator;
	int _denominator;
	int compare(const Inch& rhs); 
	void validate();
	
};
#endif

