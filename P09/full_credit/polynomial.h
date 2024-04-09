#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H
#include <iostream>
#include <ostream>
#include <vector>
#include <stdexcept>

class polynomial {
 public:
 polynomial(std::vector<double>  _coefficients){
	_coefficients = {}; 
 }
 virtual ~polynomial() { }
 virtual double solve() = 0;
 protected:
 std::vector<double> _coefficients;
};
#endif