# hashmap

## Introduction
This is a simple implementation of an integer hashmap that supports the following operations:

1. Inserting in O(1) time complexity
2. Searching and retrieving in O(1) time complexity
3. Print all numbers in ascending order in O(n) time complexity where n is the capacity of the hasmap

## Sides notes

The below are some design choices that I made for this custom implementation of the hashmap.

1. The default hashmap capacity is set to 16 when it's intialized
2. The hashmap will auto resize by doubling its size when the size reaches at least 70% of its capacity
3. The hashmap only supports int type
