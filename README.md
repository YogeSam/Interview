# Interview
Sample Program for refactoring and extending
Directory
Each node in a tree is composed of following:
EnterpriseId, OrganizationId, EnterpriseName, EnterpriseType

[{"EnterpriseId":-1,"OrganizationId":-1,"EnterpriseName":"Root","EnterpriseType":"Unit"}
 {"EnterpriseId":1,"OrganizationId":1,"EnterpriseName":"East Coast","EnterpriseType":"Unit"}
 {"EnterpriseId":2,"OrganizationId":101,"EnterpriseName":"Westboro Practice","EnterpriseType":"Practice"}
 {"EnterpriseId":3,"OrganizationId":102,"EnterpriseName":"Worcester Practice","EnterpriseType":"Practice"}
 {"EnterpriseId":4,"OrganizationId":201,"EnterpriseName":"Alls Good Facility","EnterpriseType":"Facility"}
 ]


Enterprise Hierarchy

Root
	---- East Coast
		---- Westboro Practice
		----- Worcester Practice
			---- Alls Good Facility


a)	Represent the above Enterprise hierarchy by extending the program
b)	Refactor the program to 
	1.	Build the tree
	2.	Print the tree
	3.	Search the tree - (Use Recursion where applicable)
c)	Write test cases for the refactoring modules 
d)	Find the maximum length of the tree
e)	Find the distance between the intermediate node and the tree
f)  Provide a UML spec of how to provide database operations of saving and loading the tree from the database
 
