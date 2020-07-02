import { NativeModules } from 'react-native';

type IntentsType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Intents } = NativeModules;

export default Intents as IntentsType;
