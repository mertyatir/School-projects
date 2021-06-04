
#This part is for creating the product and price lists seperately from the file.It does that by finding the "#" string.Before that string there lies products and after that, the prices.
#productlist=['BISCUIT', 'COKE', 'TEA', 'HAMBURGER', 'CHIPS', 'COFFEE', 'CHOCOLATE', 'PEACH JUICE', 'SANDWICH', 'CAKE', 'TOAST']
#pricelist=['2', '4', '1', '10', '5', '2', '2', '3', '7', '4', '5']
productlist=[ ]
pricelist=[ ]

productsandprices=open("PriceList.txt").readlines()

for i in range(len(productsandprices)):
    item=productsandprices[i]
    for j in range(len(productsandprices[i])):
        if item[j]=="#":
            productlist.append(item[0:j])
            pricelist.append(item[j+1:-1])

#This part is for creating list of sequence of students by their purchase time and corresponding (the two list have the same lenght) products by reading the PurchaseHistory.txt file.These are not useful on their own for now.
#purchasedproductsbystudents=['PEACH JUICE, CHIPS, BISCUIT, COKE', 'COKE', 'TEA, SANDWICH,COFFEE,CAKE', 'CHIPS, CHOCOLATE, COKE, COFFEE', 'COFFEE, CHOCOLATE', 'HAMBURGER, CHIPS, COFFEE', 'HAMBURGER, COKE, CHIPS', 'COFFEE, BISCUIT, TOAST', 'CHIPS, CHOCOLATE, COKE, COFFEE, SANDWICH, PEACH JUICE, BISCUIT', 'TEA, BISCUIT, CHOCOLATE, TOAST', 'CHIPS, SANDWICH, PEACH JUICE', 'CHIPS, COKE, CAKE, HAMBURGER', 'SANDWICH, PEACH JUICE, CHOCOLATE', 'COFFEE, CAKE', 'SANDWICH, PEACH JUICE, CHIPS', 'COKE, HAMBURGER, BISCUIT', 'TOAST, CAKE, TEA, CHOCOLATE, CHIPS', 'COFFEE, BISCUIT, CHOCOLATE, TOAST, COKE', 'SANDWICH, PEACH JUICE, CHOCOLATE, CHIPS, TEA', 'COKE, HAMBURGER, TOAST, CAKE, CHOCOLATE', 'PEACH JUICE, CHIPS', 'TEA, CAKE, CHIPS', 'COFFEE, CHOCOLATE ,COKE', 'CAKE, COFFEE, TEA', 'COFFEE, TEA, TOAST, CAKE, CHIPS, COKE, CHOCOLATE', 'HAMBURGER, CHIPS, COKE', 'TEA, CAKE, BISCUIT', 'PEACH JUICE, COKE, CHIPS, BISCUIT, TEA, CAKE', 'HAMBURGER, CHIPS, COKE, TOAST', 'BISCUIT, CHOCOLATE, BISCUIT, TEA', 'COFFEE, BISCUIT', 'TEA, TOAST, CHOCOLATE']
#sequenceofstudents=['STUDENT1', 'STUDENT2', 'STUDENT3', 'STUDENT4', 'STUDENT5', 'STUDENT6', 'STUDENT5', 'STUDENT4', 'STUDENT1', 'STUDENT2', 'STUDENT3', 'STUDENT4', 'STUDENT3', 'STUDENT5', 'STUDENT5', 'STUDENT4', 'STUDENT3', 'STUDENT2', 'STUDENT3', 'STUDENT2', 'STUDENT1', 'STUDENT2', 'STUDENT3', 'STUDENT4', 'STUDENT5', 'STUDENT6', 'STUDENT5', 'STUDENT4', 'STUDENT3', 'STUDENT2', 'STUDENT4', 'STUDENT5']

purchasehistory=open("PurchaseHistory.txt").readlines()
purchasedproductsbystudents=[ ]
sequenceofstudents=[ ]

for i in range(len(purchasehistory)):
    item=purchasehistory[i]
    for j in range(len(item)):
        if item[j]=="-":
            purchasedproductsbystudents.append(item[j+1:].strip())
            sequenceofstudents.append(item[0:j])
            
#This part for creating all purchased products one by one from the previous list named "purchasedproductsbystudents".It will use this list to find most selling products and revenue in total.
#purchasedproductsonebyone=['PEACH JUICE', 'CHIPS', 'BISCUIT', 'COKE', 'COKE', 'TEA', 'SANDWICH', 'COFFEE', 'CAKE', 'CHIPS', 'CHOCOLATE', 'COKE', 'COFFEE', 'COFFEE', 'CHOCOLATE', 'HAMBURGER', 'CHIPS', 'COFFEE', 'HAMBURGER', 'COKE', 'CHIPS', 'COFFEE', 'BISCUIT', 'TOAST', 'CHIPS', 'CHOCOLATE', 'COKE', 'COFFEE', 'SANDWICH', 'PEACH JUICE', 'BISCUIT', 'TEA', 'BISCUIT', 'CHOCOLATE', 'TOAST', 'CHIPS', 'SANDWICH', 'PEACH JUICE', 'CHIPS', 'COKE', 'CAKE', 'HAMBURGER', 'SANDWICH', 'PEACH JUICE', 'CHOCOLATE', 'COFFEE', 'CAKE', 'SANDWICH', 'PEACH JUICE', 'CHIPS', 'COKE', 'HAMBURGER', 'BISCUIT', 'TOAST', 'CAKE', 'TEA', 'CHOCOLATE', 'CHIPS', 'COFFEE', 'BISCUIT', 'CHOCOLATE', 'TOAST', 'COKE', 'SANDWICH', 'PEACH JUICE', 'CHOCOLATE', 'CHIPS', 'TEA', 'COKE', 'HAMBURGER', 'TOAST', 'CAKE', 'CHOCOLATE', 'PEACH JUICE', 'CHIPS', 'TEA', 'CAKE', 'CHIPS', 'COFFEE', 'CHOCOLATE', 'COKE', 'CAKE', 'COFFEE', 'TEA', 'COFFEE', 'TEA', 'TOAST', 'CAKE', 'CHIPS', 'COKE', 'CHOCOLATE', 'HAMBURGER', 'CHIPS', 'COKE', 'TEA', 'CAKE', 'BISCUIT', 'PEACH JUICE', 'COKE', 'CHIPS', 'BISCUIT', 'TEA', 'CAKE', 'HAMBURGER', 'CHIPS', 'COKE', 'TOAST', 'BISCUIT', 'CHOCOLATE', 'BISCUIT', 'TEA', 'COFFEE', 'BISCUIT', 'TEA', 'TOAST', 'CHOCOLATE']
purchasedproductsonebyone=[ ]
for i in range(len(purchasedproductsbystudents)):
    item=purchasedproductsbystudents[i].split(",")
    for j in range(len(item)):
        purchasedproductsonebyone.append(item[j].strip())

#By using purchasedproductsonebyone list, it finds the number of sales for each product and the revenue in total.It will do it by comparing purchasedproductsonebyone and product list.If it finds a match, it finds the price from the pricelist and adds to the revenue variable.
        
numberofsalesforeachproduct=[ ]
numberofsales=0
revenue=0

for i in range(len(productlist)):
    for j in range(len(purchasedproductsonebyone)):
        item=purchasedproductsonebyone[j]
        if item==productlist[i]:
            revenue=revenue+int(pricelist[i])
            numberofsales+=1
        if j==len(purchasedproductsonebyone)-1:
            numberofsalesforeachproduct.append(int(numberofsales))
            numberofsales=0
#numberofsalesforeachproduct=[11, 14, 11, 7, 16, 12, 13, 8, 6, 10, 8]

#By reading the  PurchaseHistory.txt file second time, it now creates the daylist and corresponding productsbydays.It does that by finding a "DAY#(number)" string.After that until it finds "DAY#(number+1)" string, it add all the products together then after finding it, it appends these products to the productsbydays list.By doing this, it now have the list of the days and another list of the corresponding products.
#daylist=['DAY#1', 'DAY#2', 'DAY#3', 'DAY#4', 'DAY#5', 'DAY#6', 'DAY#7']
#productsbydays=['PEACH JUICE, CHIPS, BISCUIT, COKE, COKE, TEA, SANDWICH,COFFEE,CAKE, CHIPS, CHOCOLATE, COKE, COFFEE, COFFEE, CHOCOLATE, HAMBURGER, CHIPS, COFFEE', 'HAMBURGER, COKE, CHIPS, COFFEE, BISCUIT, TOAST, CHIPS, CHOCOLATE, COKE, COFFEE, SANDWICH, PEACH JUICE, BISCUIT, TEA, BISCUIT, CHOCOLATE, TOAST, CHIPS, SANDWICH, PEACH JUICE', 'CHIPS, COKE, CAKE, HAMBURGER, SANDWICH, PEACH JUICE, CHOCOLATE, COFFEE, CAKE', 'SANDWICH, PEACH JUICE, CHIPS, COKE, HAMBURGER, BISCUIT, TOAST, CAKE, TEA, CHOCOLATE, CHIPS, COFFEE, BISCUIT, CHOCOLATE, TOAST, COKE', 'SANDWICH, PEACH JUICE, CHOCOLATE, CHIPS, TEA, COKE, HAMBURGER, TOAST, CAKE, CHOCOLATE, PEACH JUICE, CHIPS, TEA, CAKE, CHIPS, COFFEE, CHOCOLATE ,COKE, CAKE, COFFEE, TEA, COFFEE, TEA, TOAST, CAKE, CHIPS, COKE, CHOCOLATE, HAMBURGER, CHIPS, COKE', 'TEA, CAKE, BISCUIT, PEACH JUICE, COKE, CHIPS, BISCUIT, TEA, CAKE, HAMBURGER, CHIPS, COKE, TOAST', 'BISCUIT, CHOCOLATE, BISCUIT, TEA, COFFEE, BISCUIT, TEA, TOAST, CHOCOLATE']            
temp2=""
daynumber=1
daylist=[ ]
productsbydays=[ ]
for i in range(len(purchasehistory)):
    item=purchasehistory[i].strip()
    if item=="DAY#"+str(daynumber):
        daylist.append("DAY#"+str(daynumber))
        if temp2!="":
            productsbydays.append(temp2)
            temp2=" "
        daynumber+=1
        continue
    for j in range(len(item)):
        if item[j]=="-":
            temp=item[j+1:].strip()
            temp2=(temp2+", "+temp).strip(' ,')
    if i==int(len(purchasehistory))-1:
        productsbydays.append(temp2)
        
#This part find the number of students from the sequenceofstudenst list.It just finds the maximum of the numbers x in "STUDENTx"
             
numberofstudents=1
for i in range(len(sequenceofstudents)):
    if sequenceofstudents[i]=="STUDENT"+str(numberofstudents+1):
        numberofstudents+=1
        
#This part uses previous lists to find which student bought the which products.
#purchasedproductsbyeverystudent=['PEACH JUICE, CHIPS, BISCUIT, COKE, CHIPS, CHOCOLATE, COKE, COFFEE, SANDWICH, PEACH JUICE, BISCUIT, PEACH JUICE, CHIPS', 'COKE, TEA, BISCUIT, CHOCOLATE, TOAST, COFFEE, BISCUIT, CHOCOLATE, TOAST, COKE, COKE, HAMBURGER, TOAST, CAKE, CHOCOLATE, TEA, CAKE, CHIPS, BISCUIT, CHOCOLATE, BISCUIT, TEA', 'TEA, SANDWICH,COFFEE,CAKE, CHIPS, SANDWICH, PEACH JUICE, SANDWICH, PEACH JUICE, CHOCOLATE, TOAST, CAKE, TEA, CHOCOLATE, CHIPS, SANDWICH, PEACH JUICE, CHOCOLATE, CHIPS, TEA, COFFEE, CHOCOLATE ,COKE, HAMBURGER, CHIPS, COKE, TOAST', 'CHIPS, CHOCOLATE, COKE, COFFEE, COFFEE, BISCUIT, TOAST, CHIPS, COKE, CAKE, HAMBURGER, COKE, HAMBURGER, BISCUIT, CAKE, COFFEE, TEA, PEACH JUICE, COKE, CHIPS, BISCUIT, TEA, CAKE, COFFEE, BISCUIT', 'COFFEE, CHOCOLATE, HAMBURGER, COKE, CHIPS, COFFEE, CAKE, SANDWICH, PEACH JUICE, CHIPS, COFFEE, TEA, TOAST, CAKE, CHIPS, COKE, CHOCOLATE, TEA, CAKE, BISCUIT, TEA, TOAST, CHOCOLATE', 'HAMBURGER, CHIPS, COFFEE, HAMBURGER, CHIPS, COKE']
#For example student1 bought the products in purchasedproductsbyeverystudent[0]
#It creates this list by, for example, iterating in sequenceofstudents for student1 until the end of the list.After that, it appends all the products it has found for student1 and then, it looks for student2.     
purchasedproductsbyeverystudent=[ ]
x=1
temp2=" "
i=0
while i<len(sequenceofstudents):
    if sequenceofstudents[i]=="STUDENT"+str(x):
        temp=purchasedproductsbystudents[i]
        temp2=((temp2+", "+temp).strip()).strip(' ,')
    if i==len(sequenceofstudents)-1:
        purchasedproductsbyeverystudent.append(temp2)
        temp2=""
        x+=1
        i=0
    i+=1
    if x>numberofstudents:
        break

#After creating (almost) all required information, now it initializes the interface of this program.
inp=-1
while inp!=0:
    inp=int(input("Press 1 to product and price list\nPress 2 to total revenue and most selling product(s) in total\nPress 3 to daily revenue and most selling product(s)in a day\nPress 4 to total payment for a student\nPress 0 to exit."))
    if inp==1:
        print("PRODUCT"+" "*10+"PRICE")
        for i in range(len(productlist)):
        #productlist=['BISCUIT', 'COKE', 'TEA', 'HAMBURGER', 'CHIPS', 'COFFEE', 'CHOCOLATE', 'PEACH JUICE', 'SANDWICH', 'CAKE', 'TOAST']
        #pricelist=['2', '4', '1', '10', '5', '2', '2', '3', '7', '4', '5']
            print(productlist[i]+" "*(17-len(productlist[i]))+pricelist[i])
    if inp==2:
        x=0
        mostsellingproductlist=[ ]
        for i in range(len(numberofsalesforeachproduct)):
            if numberofsalesforeachproduct[i]>x:
                #numberofsalesforeachproduct=[11, 14, 11, 7, 16, 12, 13, 8, 6, 10, 8]
                x=numberofsalesforeachproduct[i]
                mostsellingproductlist=[ ]
                mostsellingproductlist.append(productlist[i])
            elif numberofsalesforeachproduct[i]==x:
                mostsellingproductlist.append(productlist[i])      
        print("Total revenue:",revenue)
        print("Most selling product(s) in total: (",x, "sales)")
        print(mostsellingproductlist)
    if inp==3:
        daynumberinput=int(input(("Select day between 1 and "+str(daynumber-1))))
        while daynumberinput<1 or daynumberinput>daynumber-1:
            daynumberinput=int(input(("Select day between 1 and "+str(daynumber-1))))
        dailyrevenue=0
        productsonebyoneforeachday=productsbydays[daynumberinput-1].split(",")
        for j in productsonebyoneforeachday:
            for k in range(len(productlist)):
                if j.strip()==productlist[k]:
                    dailyrevenue+=int(pricelist[k])
        print("Day",daynumberinput," total revenue=",dailyrevenue) 
        numberofsalesforeachproductfortheday=[ ]
        for i in range(len(productlist)):
            a=productsbydays[daynumberinput-1].split(",")
            for j in range(len(a)):
                if a[j].strip()==productlist[i]:
                    numberofsales+=1
                if j==len(a)-1:
                    numberofsalesforeachproductfortheday.append(numberofsales)
                    numberofsales=0
        bestsellingproductfortheday=[ ]            
        maxnumberofsales=0
        for i in range(len(numberofsalesforeachproductfortheday)):
            if numberofsalesforeachproductfortheday[i]>maxnumberofsales:
                bestsellingproductfortheday=[ ]
                maxnumberofsales=int(numberofsalesforeachproductfortheday[i])
                bestsellingproductfortheday.append(productlist[i])
            elif numberofsalesforeachproductfortheday[i]==maxnumberofsales:
                bestsellingproductfortheday.append(productlist[i])    
        print("Most selling product(s): (",maxnumberofsales, "sales)") 
        print(bestsellingproductfortheday)
    if inp==4:
        payment=0
        studentid=int(input("Select student ID between 1 and "+str(numberofstudents)))
        while studentid<1 or studentid>numberofstudents:
            studentid=int(input("Select student ID between 1 and "+str(numberofstudents)))
        for i in range(len(productlist)):
            for j in purchasedproductsbyeverystudent[studentid-1].split(","):
                if productlist[i]==j.strip():
                    payment+=int(pricelist[i])
                
        print("Total payment for the student",studentid,"=",payment)
        
