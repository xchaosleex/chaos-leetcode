#include <iostream>

int main()
{
    int x = 5;
    int &y = x;                  // y is a reference to x
    std::cout << x << std::endl; // prints 5
    std::cout << y << std::endl; // prints 5

    y = 7;                       // y is a reference to x, so this modifies x
    std::cout << x << std::endl; // prints 7
    std::cout << y << std::endl; // prints 7

    return 0;
}
