#include "WierszTrojkataPascala.hpp"

#include <stdexcept>


WierszTrojkataPascala::WierszTrojkataPascala(int n) noexcept(false) {
    if (n<0) { throw std::invalid_argument(""); }

    len = n;
    row = new int[(n/2)+1];
    row[0] = 1;
    for (int i=2; i<=n; i++) {
        int j = i/2;
        if (i%2==0) {
            row[j] = 2*row[j-1];
            j--;
        }
        while (j>0) {
            row[j] = row[j] + row[j-1];
            j--;
        }
    }
}


WierszTrojkataPascala::~WierszTrojkataPascala() {
    delete[] row;
}


int WierszTrojkataPascala::getValue(int k) noexcept(false) {
    if (k<0 || k>len) { throw WierszTrojkataPascala::invalid_column(); }
    if (len-k < k) { k = len-k; }
    return row[k];
}
