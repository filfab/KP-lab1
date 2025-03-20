#pragma once

#include <exception>


class WierszTrojkataPascala {
    private:
        int* row;
        int len;

    public:
        int getValue(int k) noexcept(false);

        WierszTrojkataPascala(int n) noexcept(false);
        ~WierszTrojkataPascala();

    class invalid_column : public std::exception {};
};
