#ifndef __QUADRATIC_H
#define __QUADRATIC_H

#include "polynomial.h"

class quadratic : public polynomial {
  public:
    quadratic(std::vector<double>  _coefficients);	 
    virtual ~quadratic() { }
    double solve() override;	
  };

#endif