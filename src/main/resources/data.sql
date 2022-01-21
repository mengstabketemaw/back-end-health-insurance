
insert into catagory(description, duration, name, price)
values('Individual Insurance is a health policy that you can purchase for just yourself or for your family. Individual policies are also called personal health plans. If you''d like, you can work with an insurance agent to help you go over different plans and costs.',12,'Individual Citizen Health Insurance',150)
;
insert into catagory(description, duration, name, price)
values('A Critical Illness Insurance policy covers the insured against life-threatening critical diseases such as cancer, heart attack, renal failure etc. This Critical Illness Policy provides a lump sum coverage amount that can cover exorbitant medical expenses for critical illnesses as covered under the insurance policy.',18,'Critical Citizen Health Insurance',250)
;
insert into catagory(description, duration, name, price)
values('Health Insurance for senior citizens is a type of health insurance plan that covers medical expenses incurred by people for above 60 years old. While this category enjoys a lot of benefits, they also face many uncertainties in terms of their health and fitness. For senior citizens, the best health insurance policy is the one that protects them against unexpected medical expenses and allows them to be financially independent during health emergencies. ',20,'Senior Citizen Health Insurance',50)
;
insert into catagory(description, duration, name, price)
values('A family floater health insurance, as the name suggests is a plan that is tailor made for families. It is similar to individual health plans in principle; the only difference is that it is extended to cover your entire family',10,'Family Floater',150)
;
insert into catagory(description, duration, name, price)
values('Group Insurance health plans provide coverage to a group of members, usually comprised of company employees or members of an organization. Group health members usually receive insurance at a reduced cost because the insurers risk is spread across a group of policyholders.',21,'Group Health',350)
;
insert into customer(email,fullname,password,phone)
values('abebe@gmail.com','abebe dereje','abebederge',914364164);

insert into customer(email,fullname,password,phone)
values('derege@gmail.com','dereje alemu','derejealemu',949909116);

insert into customer(email,fullname,password,phone)
values('willsmith@gmail.com','will smith','willsmith',914717127);

insert into customer(email,fullname,password,phone)
values('ademsandler@gmail.com','ademsandler sand','ademsandlersand',915555555);

insert into customer(email,fullname,password,phone)
values('kerk@gmail.com','kerk kerk','kerkkerk',936416414);

insert into customer(email,fullname,password,phone)
values('molly@gmail.com','molly mccklish','mollymccklish',951525354);

insert into policy(name,catagory,premium,tenure)
values ('Erasmundus Health Insurance','Family Floating',234,12);

insert into policy(name,catagory,premium,tenure)
values ('Falkaon Health Insurance','Individual',500,20);

insert into policy(name,catagory,premium,tenure)
values ('Nasa Health Insurance','Group Health Insurance',220,50);

insert into policy(name,catagory,premium,tenure)
values ('Carat Health Insurance','Critical Citizen',234,12);

insert into policy(name,catagory,premium,tenure)
values ('Mulalem Health Insurance','Senior Citizen',23,20);