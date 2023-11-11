FROM node:16-alpine as build-stage

RUN npm install -g yarn  --force

WORKDIR /admim

COPY .npmrc package.json yarn.lock ./
RUN yarn install

COPY . .
ARG NODE_ENV=""
RUN env ${NODE_ENV} yarn build:prod

## -- nginx --
FROM nginx:alpine

ENV TZ=Asia/Shanghai

COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build-stage /admim/dist /usr/share/nginx/html

EXPOSE 80