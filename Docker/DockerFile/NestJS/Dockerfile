# Stage 1: Build

FROM node:18-alpine AS build

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY . . 

RUN npm run build

#Stage 2: Run

FROM node:18-alpine

WORKDIR /app

COPY --from=build /app/node_modules ./node_modules

COPY --from=build /app .


EXPOSE 3000

CMD ["node", "dist/main.js"]
