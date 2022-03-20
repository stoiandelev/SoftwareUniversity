import * as api from './api-crud.js';

export let login = api.login;
export let register = api.register;
export let logout = api.logout;


let endPoint = {
    topics: "/data/topics?select=_id,title",
    createTopic: "/data/topics",
    topicCount: "/data/topics?count",
    TopicById: "/data/topics/"



};

export function getAllTopics() {
    return api.get(endPoint.topics);
}

export async function getTopicCount() {
    return api.get(endPoint.topicCount);
};


export async function createTopic(topic) {
    return api.post(endPoint.createTopic, topic);
};

export async function getTopicById(id) {
    return api.get(endPoint.TopicById + id);
};





