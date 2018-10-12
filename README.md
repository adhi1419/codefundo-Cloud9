# Codefundo Project Idea - Cloud 9

## Abstract
This project’s basic idea is based on a mobile application which is to be installed on user’s device(s) before the event of the disaster. The aim is to tackle the critical problem of lack of mobile connectivity, which can be partially restored by creating virtual networks. This will solve common problems faced during disasters such as finding supplies, information regarding safe paths, safe spots, mutual help, groups etc. This can be achieved with the use Aerial Vehicles (Drones), microcells and other such portable networks.

## Introduction
The app will be functional for both online and offline (limited) usage. In offline mode the users will connect to one of the deployed devices, such as -
- Microcell
- Local Wi-Fi
- 4G LTE (Device-to-device communication is currently under research)

Microcells will be deployed using drones in areas where cellular network is not available, when connected to a local network every node will act as a router and the information about the local nodes will be routed and updated to every node on the network. The users on the local network can send SOS alerts, communicate and coordinate with each other to reach a safe place. The users have the ability to mark places as safe or unsafe. The collected information will be used to generate a map which will display -
- Safe locations
- Safe directions to places
- Location of other people/nodes
- Unreachable/damaged places

Other than the Map UI, users will be able to enter supply requirements like food, medicine and portable power.

Once the the network grows large, the network will be divided into smaller groups based on number of people and geographical distance. A base server will store information about all networks and nodes.

## Plan of Action
### Before the disaster
Before a disaster the app will use state of the art machine learning techniques and function like a normal weather app with added functionality about warnings and weather news and predicting natural disasters. This functionality is to keep the app installed in user’s device before the disaster strikes as it may be the case that the user is not able to install the app after the disaster. 

### During the disaster 
#### Phase I
During the disaster, with the information of recently disconnected nodes from a particular area we’ll be able to predict the areas which have lost cellular network connectivity. To bring those areas back in network, mobile microcells will be sent using aerial vehicles. While some microcell drones will keep moving for surveillance purposes and will share information among networks, other microcells will be permanently deployed at a particular place or with a local network. 

#### Phase II
After establishing reasonable connectivity with the help of microcells, other logistical issues can also solved like -
- Sending supplies to physically disconnected areas using drones
- Identifying high population areas and sending manpower
- Communicating and sending news/updates to a particular network
