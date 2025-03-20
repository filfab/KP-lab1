#include "WierszTrojkataPascala.hpp"

#include <iostream>
#include <string>
#include <stdexcept>


int main(int argc, char const *argv[]) {
    if (argc < 2) {
        std::cout << "niepoprawna liczba argumentów" << std::endl;
        return 0;
    }

    int n;
    try { n = std::stoi(argv[1]); }
    catch (const std::invalid_argument& e) {
        std::cout << argv[1] << " - nieprawidłowy numer wiersza" << std::endl;
        return 0;
    }

    WierszTrojkataPascala* row;
    try { row = new WierszTrojkataPascala(n); }
    catch (const std::invalid_argument& e) {
        std::cout << argv[1] << " - numer wiersza musi byc liczbą naturalną" << std::endl;
        return 0;
    }

    for (int i=2; i<argc; i++) {
        try {
            std::cout << argv[i] << " - " << std::flush << row->getValue(std::stoi(argv[i])) << std::endl;
        } catch (const WierszTrojkataPascala::invalid_column& e) {
            std::cout << "liczba z poza zakresu" << std::endl;
        } catch (const std::invalid_argument& e) {
            std::cout << "nieprawidłowa dana" << std::endl;
        }
    }

    delete row;
    return 0;
}
