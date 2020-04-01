# Cash Register

## Objects
**CashRegister** *Service Class*

**Employee**

**Product**

**ShoppingCart**

**Transaction**

**PaymentMethod**

**FoodProduct** *(child of Product)*

**ElectronicProduct** *(child of Product)*

**ClothingProduct** *(child of Product)*



## Actions
**Employee GetTopEmployee()** - Returns the Employee object with the most sales

**ShoppingCart GetActiveCart()** - Returns the ActiveCart

**Product GetProduct(int productId)** - Returns the Product that has the ID equal to *productId*

**Employee GetEmployee(int employeeId)** - Returns the Employee that has the ID equal to *employeeId*

**PaymentMethod GetPaymentMethod(int paymentMethodId)** - Returns the PaymentMethod that has the ID equal to *paymentMethodId*

**Employee CreateEmployee(String name)** - Creates an Employee and returns the object

**Product CreateProduct(String name, float price)** - Creates a Product and returns the object
**Product CreateElectronicProduct(String name, float price, int monthsWarranty)** - Creates an ElectronicProduct and returns the object
**Product CreateClothingProduct(String name, float price, String size)** - Creates a ClothingProduct and returns the object

**PaymentMethod CreatePaymentMethod(String name)** - Creates a PaymentMethod and returns the object

**void SetActiveEmployee(int employeeId)** - Changes the current ActiveEmployee to the one that has the ID equal to *employeeId*

**ShoppingCart AddToCart(int productId)** - Adds the Product that has the ID equal to *productId* to the ActiveCart

**ShoppingCart AddToCart(int productId, int amount)** - Adds the Product that has the ID equal to *productId* to the ActiveCart *amount* times

**void RemoveFromCart(int pos)** - Removes the item that is at the *pos* position in the ActiveCart

**void EmptyCart()** - Removes everything from the ActiveCart

**Transaction TransactionCompleted(int paymentMethodId)** - Creates a new Transaction using the PaymentMethod that has the ID equal to *paymentMethod*

**void PrintCart()** - Shows information about the ActiveCart

**void PrintAllTransactions()** - Shows all Transactions

**void PrintSeparator()** - Prints a line
