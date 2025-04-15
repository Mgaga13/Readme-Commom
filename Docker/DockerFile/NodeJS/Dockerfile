#Stage 1: Build
FROM node:18-alpine AS build

WORKDIR /app

COPY package*.json ./

RUN npm ci --only=production

COPY . .

RUN npm run build


#Stage 2: Run

FROM node:18-alpine 

WORKDIR /app

COPY --from=build /app/node_modules ./node_modules
COPY --from=build /app .


ENV NODE_ENV = production

EXPOSE 3000

CMD ["node", "server.js"]