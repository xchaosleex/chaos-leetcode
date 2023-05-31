#include <iostream>
#include <unordered_map>
#include <string>
#include <utility>

using namespace std;

class UndergroundSystem
{
public:
    unordered_map<int, pair<string, int>> userMp;
    unordered_map<string, pair<int, int>> distance;

    UndergroundSystem()
    {
        userMp = unordered_map<int, pair<string, int>>();
        distance = unordered_map<string, pair<int, int>>();
    }

    void checkIn(int id, string stationName, int t)
    {
        userMp[id] = {stationName, t};
    }

    void checkOut(int id, string stationName, int t)
    {
        auto [startStation, time] = userMp[id];
        string start_end = startStation + "->" + stationName;
        auto [total, cnt] = distance[start_end];
        distance[start_end] = {total + (t - time), cnt + 1};
    }

    double getAverageTime(string startStation, string endStation)
    {
        string start_end = startStation + "->" + endStation;
        auto [time, cnt] = distance[start_end];
        return (double)time / cnt;
    }
};

int main()
{
    UndergroundSystem *obj = new UndergroundSystem(); // create an instance of the UndergroundSystem class

    // call the checkIn and checkOut functions
    obj->checkIn(1, "A", 10);
    obj->checkOut(1, "B", 20);
    obj->checkIn(2, "C", 50);
    obj->checkOut(2, "D", 100);

    // call the getAverageTime function
    double avgTimeAB = obj->getAverageTime("A", "B");
    double avgTimeBC = obj->getAverageTime("C", "D");

    // print the average times
    cout << "Average time from A to B: " << avgTimeAB << endl;
    cout << "Average time from B to C: " << avgTimeBC << endl;

    return 0;
}