taxes_project
=============
## Notes
This project evaluates taxes for the Socrata Coding Challenge. Rules are

*Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.*

*When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid.  The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax*

## Requirements

You need to have Scala (2.10.3) and SBT installed. 

## How to Use
To Run:

```
sbt run /path/to/input_file.txt
```
To Run Tests:

```
sbt test
```

Input must be in the form of

```
Input 1:

1 book at 12.49

1 music CD at 14.99

1 chocolate bar at 0.85
```

Or Generically

```
Input {Num Input}:

{Num Items} {item time} at {price per item}
```

## Notes

It would have been smart to implement some sort of currency/money class. At some points, it takes a more pythonic style due to the author's biases. There are still a few formattting errors re only printing two digits that I'd like to fix, but my brain is too tired to deal with formating strings at 4 in the morning.  


