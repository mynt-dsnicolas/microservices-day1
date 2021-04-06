Mini Gcash
==========================================================================
The application is a hybrid architecture defined both by subdomains
and business capabilities.

The user can access his/her account (if he is already registered) via
a login service through an API gateway.

The user management service handles the account's profile information, balance 
and past transactions.

The marketplace service handles the placement, buying and selling of products
from Gcash.

The transactions service handles the inflow and outflow of funds from 
the user's balance.

The rewards service covers the accumulation of points from past
transactions.

The transactions service is interrelated with the awards, user management
and marketplace service since it conveys monetary information
to indicate whether funds should be added or subtracted from a user's
balance.