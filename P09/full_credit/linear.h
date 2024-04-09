#ifndef __LINEAR_H
#define __LINEAR_H

#include "polynomial.h"

class linear : public polynomial {
  public:
  linear(std::vector<double>  _coefficients);
  //  std::vector<double> numbers = {10.0, 20.0, 30.0};   
    virtual ~linear() { }
    double solve() override;
protected:
 std::vector<double> _coefficients;	
  };

#endif