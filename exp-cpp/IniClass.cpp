#include <iostream>

class TestClass
{
public:
    int a;
    int b;
    TestClass(int a, int b)
    {
        this->a = a;
        this->b = b;
    }
};

int main()
{
    TestClass *obj ;//= new TestClass(1, 2);
    std::cout << obj << std::endl;
    std::cout << obj->a << std::endl;
    std::cout << obj->b << std::endl;
    return 0;
}