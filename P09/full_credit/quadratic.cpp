#include "quadratic.h"
#include <cmath>
using namespace std;
std::vector<double> numbers = {10.0, 20.0, 30.0,40.0};

double solve() {
	double a = numbers[0];
	double b = numbers[1];
	double c = numbers[2];
	
	double num1 = b*b - 4*a*c;
	double x1 = (-b + std::sqrt(num1)) / (2*a);
    double x2 = (-b - std::sqrt(num1)) / (2*a);
    return (x1);
}