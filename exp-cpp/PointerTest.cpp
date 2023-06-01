#include <iostream>

int main()
{
    // int *p1 = nullptr; // equivalent to int *p1 = 0;
    // int *p2 = 0;       // directly initializes p2 from the literal constant 0
    // // must #include cstdlib
    // int *p3 = NULL; // equivalent to int *p3 = 0;

    // std::cout << "p1 is " << p1 << '\n';
    // std::cout << "p2 is " << p2 << '\n';
    // std::cout << "p3 is " << p3 << '\n';

    int *p1, p2; // p1 is a pointer to int; p2 is an int
    std::cout << "p1 is " << p1 << '\n';
    std::cout << "p2 is " << p2 << '\n';
}