Question Description:

Incense Sticks and Fragrance
There are two incense sticks in a house.The fragrance is produced only when the individual aroma from each of these sticks react, the location of both the sticks is given.
There are N locations in the house and coordinates of each location is given. When a stick is burnt, its aroma spreads in the circular-form (this happens for both sticks). Each second it increases its radius by one meter.
You need to calculate the number of locations to which the fragrance can reach at the time t. Aroma from the incense sticks starts at t = 0.

Input :
The first line contains two integers x1 and y1 denoting coordinates of the first incense stick.
The second line contains two integers x2 and y2 denoting coordinates of the second incense stick.
Next line contains N, denoting the number of locations in the house.
Next line contains N-space separated integers denoting x coordinate of the i-th location.
Next line contains N-space separated integers denoting y coordinate of the i-th location.
Next line contains Q, denoting the number of queries.
Next line contains Q space-separated integers, each integer being a value of t for which you have to answer the number of locations affected.

Output 
Output will contain Q space separated integers denoting number of affected locations at each of the query input. 

Constraints 
1≤N≤1000
0≤x1,y1,x2,y 2≤1000
0≤xandycoordinatesoflocati ons≤1000
1≤Q,t≤1000

Sample Input
1 2
4 5
3
2 5 7
3 6 8
3
1 6 15

Sample Output
0 2 3

Explanation
In sample input at time t = 1, there is no location which gets the fragrance and at t = 6, locations at (2,3) and (5,6) are affected and at t = 15, all locations are affected.
