#include <vector>

class ParkingSystem
{
private:
public:
    vector<int> v;
    ParkingSystem(int big, int medium, int small)
    {
        v = {big, medium, small};
    }

    bool addCar(int c)
    {
        return (v[c - 1] ? v[c - 1]-- : 0);
    }
};
